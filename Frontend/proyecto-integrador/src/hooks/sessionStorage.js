export const sessionClosed = () => {
    var session = sessionStorage.getItem('sessionIniciada')
    if(session){
        sessionStorage.removeItem('sessionIniciada')
    }
    window.location.href = window.location.origin
}
