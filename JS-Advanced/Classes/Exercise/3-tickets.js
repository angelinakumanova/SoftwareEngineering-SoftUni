class Ticket {
    constructor(destination, price, status) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }


}

function solve(array, criterion) {
    const ticketsArray = array.map(t => {
        const [destination, price, status] = t.split('|');

        return new Ticket(destination, Number(price), status);
    });

    const sortingAlg = criterion === 'price' 
    ? (a, b) => a.price - b.price 
    : (a, b) => a[criterion].localeCompare(b[criterion]);
    
    const sortedTickets = ticketsArray.sort((firstTicket, secondTicket) => sortingAlg(firstTicket, secondTicket));

    return sortedTickets;
}

console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
   'destination'));
