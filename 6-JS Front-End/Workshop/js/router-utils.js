export function hideSections() {
    const mainElement = document.querySelector('#wrapper > main');

    Array.from(mainElement.children).forEach(section => section.style.display = 'none');
}

export function redirect(url) {
    history.pushState(null, null, url);

    window.dispatchEvent(new CustomEvent('popstate'));
}
