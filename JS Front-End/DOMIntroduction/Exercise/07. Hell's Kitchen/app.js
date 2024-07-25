function solve() {

   document.querySelector('#btnSend').addEventListener('click', onClick);
   //["Mikes - Steve 1000, Ivan 200, Paul 800", "Fleet - Maria 850, Janet 650"]
   function onClick () {
      const textAreaElement = document.querySelector('textarea');
      const input = JSON.parse(textAreaElement.value);
      const pWorkers = document.querySelector('#outputs #workers p');
      const restaurants = {};

      pWorkers.textContent = '';

      for (const restaurant of input) {
         const [restaurantName, workersInfo] = restaurant.split(' - ');
         
         if (!restaurants.hasOwnProperty(restaurantName)) {
            const restaurant = {
               totalSalary: 0,
               workers: [],
            };

            restaurants[restaurantName] = restaurant;
         }

         const workers = workersInfo.split(', ');
         for (const worker of workers) {
            const [name, salary] = worker.split(' ');

            const currentWorker = {
               name,
               salary: Number(salary),
            }

            restaurants[restaurantName].totalSalary += Number(salary);
            restaurants[restaurantName].workers.push(currentWorker);
         }
         
      }


      const bestRestaurant = Object.entries(restaurants).sort(([,firstRestaurant], [,secondRestaurant]) => {
         const firstRestaurantAvgSalary = firstRestaurant.totalSalary / firstRestaurant.workers.length;
         const secondRestaurantAvgSalary = secondRestaurant.totalSalary / secondRestaurant.workers.length;

         return secondRestaurantAvgSalary - firstRestaurantAvgSalary;
      })[0];
      
      
      const sortedWorkers = bestRestaurant[1].workers.sort((firstWorker, secondWorker) => secondWorker.salary - firstWorker.salary);

      const highestSalary = sortedWorkers[0].salary;

      const bestRestaurantOutput = `Name: ${bestRestaurant[0]} Average Salary: ${(Number(bestRestaurant[1].totalSalary) / bestRestaurant[1].workers.length).toFixed(2)} Best Salary: ${highestSalary.toFixed(2)}`;

      const pBestRestaurantElement = document.querySelector('#outputs #bestRestaurant p');
      pBestRestaurantElement.textContent = bestRestaurantOutput;

      
      for (const worker of sortedWorkers) {
         pWorkers.textContent += `Name: ${worker.name} With Salary: ${worker.salary} `;
      }

      pWorkers.textContent.trim();
      

   }
}
