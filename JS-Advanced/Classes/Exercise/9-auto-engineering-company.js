function solve(input) {
    const carBrandsMap = new Map();

    for (const line of input) {
        const [carBrand, carModel, quantity] = line.split(' | ');

        carBrandsMap.set(carBrand, carBrandsMap.get(carBrand) || new Map());
        const currentModels = carBrandsMap.get(carBrand);

        currentModels.set(carModel, (currentModels.get(carModel) || 0) + Number(quantity));

    }

    for (const [carBrand, models] of carBrandsMap) {
        console.log(`${carBrand}`);
        
        for(const[carModel, quantity] of models) {
            console.log(`###${carModel} -> ${quantity}`);   
        }
    }
    
}

solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);
