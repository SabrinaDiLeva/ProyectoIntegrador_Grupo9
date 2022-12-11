export const sessionClosed = () => {
    var session = localStorage.getItem('jwt')
    if(session){
        localStorage.clear();
    }
    window.location.href = window.location.origin
}
