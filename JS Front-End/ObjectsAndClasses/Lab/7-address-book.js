function solve(input) {
    const addressBook = {};
    
    for (const line of input) {
        const tokens = line.split(':');
        const personName = tokens[0];
        const address = tokens[1];
        
        addressBook[personName] = address;
    }
    
   Object.entries(addressBook).sort((a, b) => a[0].localeCompare(b[0]))
   .forEach(([personName, address]) => console.log(`${personName} -> ${address}`));
    
}

solve(['Tim:Doe Crossing','Bill:Nelson Place','Peter:Carlyle Ave','Bill:Ornery Rd']);
solve(['Bob:Huxley Rd','John:Milwaukee Crossing','Peter:Fordem Ave','Bob:Redwing Ave','George:Mesta Crossing','Ted:Gateway Way','Bill:Gateway Way','John:Grover Rd','Peter:Huxley Rd','Jeff:Gateway Way','Jeff:Huxley Rd'])
