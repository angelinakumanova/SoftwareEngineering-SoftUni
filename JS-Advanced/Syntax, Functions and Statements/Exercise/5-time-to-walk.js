function solve(steps, footPrint, speed) {
    const distance = steps * footPrint;
    const speedMetersPerSec = speed / 3.6;
    const walkingTimeSeconds = distance / speedMetersPerSec;

    const breaksCount = Math.floor(distance / 500);
    const breakTimeSeconds = breaksCount * 60;

    const totalTime = walkingTimeSeconds + breakTimeSeconds;

    const hours = Math.floor(totalTime / 3600);
    const minutes = Math.floor((totalTime % 3600) / 60);
    const seconds = Math.round(totalTime % 60);

    console.log(`${String(hours).padStart(2, '0')}:${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`);
    
}

solve(4000, 0.60, 5);
