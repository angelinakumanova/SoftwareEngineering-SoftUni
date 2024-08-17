function solve([numberOfPianists, ...rest]) {
    const pieces = (rest.slice(0, numberOfPianists)).map(piece => {
        const tokens = piece.split('\|');
        const name = tokens[0];
        const composer = tokens[1];
        const key = tokens[2];

        return {
            name,
            composer,
            key,
        };
    });

    const commands = rest.slice(numberOfPianists);

    for (const command of commands) {

        if (command === 'Stop') {
            printPieces(pieces);
            return;
        }

        const tokens = command.split('\|');
        const action = tokens[0];
        const pieceName = tokens[1];

        const piece = pieces.find(piece => piece.name === pieceName);

        if (action === 'Add') {
            if (piece) {
                console.log(`${piece.name} is already in the collection!`);
                continue;
            }

            const composer = tokens[2];
            const key = tokens[3];
            addPiece(pieceName, composer, key)
        } else if (action === 'Remove') {
            removePiece(piece, pieceName);

        } else if (action === 'ChangeKey') {
            const newKey = tokens[2];

            changeKeyOfPiece(piece, newKey, pieceName);
        }
    }

    function addPiece(name, composer, key) {
        const newPiece = {
            name,
            composer,
            key,
        };

        pieces.push(newPiece);

        console.log(`${name} by ${composer} in ${key} added to the collection!`);
        
    }

    function removePiece(piece, pieceName) {
        if (piece) {
            const indexOfPiece = pieces.indexOf(piece);
            pieces.splice(indexOfPiece, 1);
            console.log(`Successfully removed ${pieceName}!`);
            return;
        }

        console.log(`Invalid operation! ${pieceName} does not exist in the collection.`);
    }

    function changeKeyOfPiece(piece, newKey, pieceName) {
        if (piece) {
            piece.key = newKey;
            console.log(`Changed the key of ${pieceName} to ${newKey}!`);
            return;
            
        }

        console.log(`Invalid operation! ${pieceName} does not exist in the collection.`);
        
    }

    function printPieces(pieces) {
        pieces.forEach(piece => {
            console.log(`${piece.name} -> Composer: ${piece.composer}, Key: ${piece.key}`);
            
        });
    }
}

solve([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'  
  ]);
