function solve(input) {
    /*"user {username}" – add the user to the list of users
    "article {article name}" – add the article to the article list
    "{username} posts on {article name}: {comment title}, {comment content}" – save the info */
    const articles = {};
    const users = [];


    for (const line of input) {

        if (line.includes('user')) {
            const [ , username] = line.split(' ');
            users.push(username);
        } else if (line.includes('article')) {
            const [ , articleName] = line.split(' ');
            articles[articleName] = [];
        } else {
            const tokens = line.split(': ');
            const [username, articleName] = tokens[0].split(' posts on ');
            const[commentTitle, commentContent] = tokens[1].split(', ');

            if (users.includes(username) && articles.hasOwnProperty(articleName)) {
                const user = {
                    username,
                    commentTitle,
                    commentContent
                }
                articles[articleName].push(user);
            }

        }
    }

    /* "Comments on {article1 name}
        --- From user {username1}: {comment title} - {comment content}
        --- From user {username2}: …
        Comments on {article2 name} */


    Object.entries(articles).sort(([, firstArticleComments], [, secondArticleComments]) => {
        const firstUserCommentsCount = firstArticleComments.length;
        const secondUserCommentsCount = secondArticleComments.length;

        return secondUserCommentsCount - firstUserCommentsCount;
    }).forEach(([article, usersComments]) => {
        console.log(`Comments on ${article}`);

        usersComments
        .sort((firstUser, secondUser) => firstUser.username.localeCompare(secondUser.username))
        .forEach((user) => {
            console.log(`--- From user ${user.username}: ${user.commentTitle} - ${user.commentContent}`);
        });
    })
}

solve(['user aUser123', 'someUser posts on someArticle: NoTitle, stupidComment', 'article Books', 'article Movies', 'article Shopping', 'user someUser', 'user uSeR4', 'user lastUser', 'uSeR4 posts on Books: I like books, I do really like them', 'uSeR4 posts on Movies: I also like movies, I really do', 'someUser posts on Shopping: title, I go shopping every day', 'someUser posts on Movies: Like, I also like movies very much']);
