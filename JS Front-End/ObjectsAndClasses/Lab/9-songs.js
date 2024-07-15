function solve(input) {
    const numberOfSongs = input[0];

    const songs = [];

    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    for (let i = 1; i <= numberOfSongs; i++) {
        const tokens = input[i].split('_');
        const typeOfSong = tokens[0];
        const name = tokens[1];
        const lengthOfSong = tokens[2];

        const song = new Song(typeOfSong, name, lengthOfSong);
        songs.push(song);
    }

    const wantedType = input[input.length - 1];
    
    for (const song of songs) {

        if (wantedType == 'all') {
            console.log(song.name);
        } else if (song.typeList === wantedType) {
            console.log(song.name);
        } 
        
    }
}

solve([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']);

solve([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']);

solve([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']);
