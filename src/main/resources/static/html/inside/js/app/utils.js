
function save2Local(key, value){
    if (!key) return;
    if (typeof value !== 'string') {
        value = JSON.stringify(value);
    }
    localStorage.setItem(key, value);
}

function getFromLocal(key){
    return localStorage.getItem(key)?JSON.parse(localStorage.getItem(key)):'';
}

function removeFromLocal(key){
    return localStorage.removeItem(key);
}