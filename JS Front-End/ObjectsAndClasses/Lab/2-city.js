function printObjectInfo(object) {
    console.log(`name -> ${object.name}`);
    console.log(`area -> ${object.area}`);
    console.log(`population -> ${object.population}`);
    console.log(`country -> ${object.country}`);
    console.log(`postCode -> ${object.postCode}`);
}

printObjectInfo({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
});
printObjectInfo({
    name: "Plovdiv",
    area: 389,
    population: 1162358,
    country: "Bulgaria",
    postCode: "4000"
});
