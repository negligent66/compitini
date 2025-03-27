function loadMenu() {
    let negro = document.getElementById("pollo");
    negro.innerHTML =
        `<div class ="row"> <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="index.html">Home</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Primi.html">Primi</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Secondo.html">Secondi</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Contatti.html">Contatti</a></div>
        <div class="col text-center"></div>`;
        
    var url = "http://192.168.160.105:8000/";
    fetch(url + "torte").then(
        response => response.json()
    ).then((data) => {
        var torte = "";
        data.forEach(element => {
            torte += `<div class="menu-elementi">
                <img src="` + url + `immagini/` + element.immagine + `" alt="non esiste"
                    class="immagini-menu">
                <div>
                    <h3>` + element.nome + `</h2>
                    <p>PREZZO: ` + element.prezzo + `£</p>
                </div>
            </div>`;
        });
        
        let hr = document.getElementById("torte");
        hr.innerHTML = torte;
    }).catch(error => console.log("Si è verificato un errore!"))


    fetch(url + "gelati").then(
        response => response.json()
    ).then((data) => {
        var gelati = "";
        data.forEach(element => {
            gelati += `<div class="menu-elementi">
                <img src="` + url + `immagini/` + element.immagine + `" alt="non esiste"
                    class="immagini-menu">
                <div>
                    <h3>` + element.nome + `</h2>
                    <p>PREZZO: ` + element.prezzo + `£</p>
                </div>
            </div>`;
        });
        
        let hr = document.getElementById("gelati");
        hr.innerHTML = gelati;
    }).catch(error => console.log("Si è verificato un errore!"))
}

