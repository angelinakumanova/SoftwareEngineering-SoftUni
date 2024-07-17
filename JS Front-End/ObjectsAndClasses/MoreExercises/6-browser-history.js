function solve(browser, actions) {
    
    for (const siteAction of actions) {
        const tokens = siteAction.split(' ');
        const action = tokens[0];
        const site = siteAction.substring(action.length + 1);
        
        const openTabs = browser['Open Tabs'];
        const browserLogs = browser['Browser Logs'];
        const recentlyClosedTabs = browser['Recently Closed'];
        
        if (action === 'Open') {
            if (!openTabs.includes(site)) {
                openTabs.push(site);
                browserLogs.push(siteAction);
                
                if (recentlyClosedTabs.includes(site)) {
                    const indexOfSite = recentlyClosedTabs.indexOf(site);
                    recentlyClosedTabs.splice(indexOfSite, 1);
                }
            }
            
        } else if (action === 'Close') {
            if (openTabs.includes(site)) {
                recentlyClosedTabs.push(site);
                browserLogs.push(siteAction);
                
                const indexOfSite = openTabs.indexOf(site);
                openTabs.splice(indexOfSite, 1);
                
            }
        } else if (siteAction === 'Clear History and Cache') {
            browser['Open Tabs'] = [];
            browser['Recently Closed'] = [];
            browser['Browser Logs'] = [];
        }
    }

    console.log(browser['Browser Name']);
    console.log(`Open Tabs: ${browser['Open Tabs'].join(', ')}`);
    console.log(`Recently Closed: ${browser['Recently Closed'].join(', ')}`);
    console.log(`Browser Logs: ${browser['Browser Logs'].join(', ')}`);
}

// solve({"Browser Name":"Google Chrome","Open Tabs":["Facebook","YouTube","Google Translate"],
//     "Recently Closed":["Yahoo","Gmail"],
//     "Browser Logs":["Open YouTube","Open Yahoo","Open Google Translate","Close Yahoo","Open Gmail","Close Gmail","Open Facebook"]},
//     ["Close Facebook", "Open StackOverFlow", "Open Google"]
// );
solve({"Browser Name":"Mozilla Firefox",
    "Open Tabs":["YouTube"],
    "Recently Closed":["Gmail", "Dropbox"],
    "Browser Logs":["Open Gmail", "Close Gmail", "Open Dropbox", "Open YouTube", "Close Dropbox"]},
    ["Open Wikipedia", "Clear History and Cache", "Open Twitter"]
);
