import { hideSections, redirect } from "./router-utils.js";
import { renderCreate, renderDetails, renderHeader, renderHome, renderLogin, renderLogout, renderRegister, renderSolutions } from "./views.js";


export const routes = {
    '/': renderHome,
    '/solutions': renderSolutions,
    '/solutions/add': renderCreate,
    '/solutions/:solutionId/details': renderDetails,
    '/login': renderLogin,
    '/register': renderRegister,
    '/logout': renderLogout,
    
};

function matchRoute(path) {
    for (const route in routes) {
        const routeSegments = route.split('/');
        const pathSegments = path.split('/');

        if (routeSegments.length !== pathSegments.length) {
            continue;
        }

        let params = {};
        let match = true;

        for (let i = 0; i < routeSegments.length; i++) {
            if (routeSegments[i].startsWith(':')) {
                params[routeSegments[i].slice(1)] = pathSegments[i];
            } else if (routeSegments[i] !== pathSegments[i]) {
                match = false;
                break;
            }
            
        }

        if (match) {
            return routes[route].bind(null, params);
        }
    }
}

export function setupRouter() {
    hideSections();
    renderHeader();

    matchRoute(location.pathname)();

    window.addEventListener('popstate', () => {
        hideSections();
        renderHeader();

        matchRoute(location.pathname)();
    });
}

export function setupLinks() {
    const siteWrapperElement = document.getElementById('wrapper');

    siteWrapperElement.addEventListener('click', (e) => {
        if (e.target.tagName === 'A') {
            e.preventDefault();

            const url = new URL(e.target.href);

            redirect(url.pathname);
        }
    })
}
