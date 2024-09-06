function getLowestPricesInCities(input) {
    const products = {};

    for (const iterator of input) {
        const [cityName, product, price] = iterator.split(' \| ');

        const city = {cityName, price: Number(price)};
        if (!products[product]) {
            products[product] = [city];
        } else {
            const cities = products[product];
            cities.push(city);
        }
    }

    

    Object.entries(products).forEach(([product, cities]) => {
        const sortedCitiesByPrice = cities.sort((firstProduct, secondProduct) => firstProduct.price - secondProduct.price);
        
        const cheapestProduct = sortedCitiesByPrice[0];
        console.log(`${product} -> ${cheapestProduct.price} (${cheapestProduct.cityName})`);
    });
    
}

getLowestPricesInCities(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']);
