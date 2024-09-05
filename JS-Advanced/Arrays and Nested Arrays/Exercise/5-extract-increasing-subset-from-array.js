function solve(array = []) {
    return array.reduce((subset, current) => {
        if (subset.length === 0 || current >= subset[subset.length - 1]) {
          subset.push(current); 
        }
        return subset; 
      }, []);
      
}

console.log(
    solve([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]));

