class Post {
    constructor(title, content) {
        this.title = title;
        this.content = content;
    }

    toString() {
        return `Post: ${this.title}\nContent: ${this.content}`;
    }
}

class SocialMediaPost extends Post {
    #comments = [];

    constructor(title, content, likes, dislikes) {
        super(title, content);
        this.likes = likes;
        this.dislikes = dislikes;
    } 

    addComment(comment) {
        this.#comments.push(comment);
    }

    toString() {
        return super.toString() + `\nRating: ${this.likes - this.dislikes}\nComments:\n${this.#comments.map(comment => `* ${comment}`).join('\n')}`;
    }
}

class BlogPost extends Post {
    #views;

    constructor(title, content, views) {
        super(title, content);
        this.#views = views || 0;
    }

    view() {
        this.#views++;

        return this;
    }

    toString() {
        return super.toString() + `\nViews: ${this.#views}`;
    }
}

let post = new Post("Post", "Content");

console.log(post.toString());

// Post: Post
// Content: Content

let scm = new SocialMediaPost("TestTitle", "TestContent", 25, 30);

scm.addComment("Good post");
scm.addComment("Very good post");
scm.addComment("Wow!");

console.log(scm.toString());

// Post: TestTitle
// Content: TestContent
// Rating: -5
// Comments:
//  * Good post
//  * Very good post
//  * Wow!

let bp = new BlogPost("TestTitle", "TestContent", 30);
bp.view().view().view();

console.log(bp.toString());

