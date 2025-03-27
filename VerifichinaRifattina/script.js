let articoli = [
    {
        nome: "sensore infrarossi",
        fileImg: "Art1SensorePIR.jpg",
        tipologia: "sensori",
        prezzo: 2.90
    },
    {
        nome: "sensore di fiamma",
        fileImg: "Art2SensoreFiamma.jpg",
        tipologia: "sensori",
        prezzo: 2.50
    },
    {
        nome: "motor shield",
        fileImg: "Art3MotorShield.jpg",
        tipologia: "controllo",
        prezzo: 19.90
    },
    {
        nome: "servomotore",
        fileImg: "Art4Servomotore.jpg",
        tipologia: "motori",
        prezzo: 5.90
    },
    {
        nome: "motoriduttore",
        fileImg: "Art5Motoriduttore.jpg",
        tipologia: "motori",
        prezzo: 65.90
    },
    {
        nome: "display touch",
        fileImg: "Art6DisplayTouch.jpg",
        tipologia: "display",
        prezzo: 89.90
    }
];
let carrello = [];
function loadMenu() {
    let menu = document.getElementById("lista");
    for (let i = 0; i < articoli.length; i++) {
        menu.innerHTML += `
        <div class="menu-item">
            <img src="./img/${articoli[i].fileImg}" alt="non esiste" class="immagini" onclick="addToCart(${i})">
            <div class="description">
                <div>${articoli[i].nome}</div>
                <div>(${articoli[i].tipologia})</div>
                <div>Prezzo: ${articoli[i].prezzo}€</div>
            </div>
        </div>`;
    }
}
function addToCart(i) {
    carrello.push({
        nome: articoli[i].nome,
        prezzo: articoli[i].prezzo,
    });
    updateCart();
}
function updateCart() {
    let cart = document.getElementById("carrello");
    cart.innerHTML = "<div style='text-align: center;'>CARRELLO</div><br>"; // Resetta il contenuto del carrello

    for (let i = 0; i < carrello.length; i++) {
        cart.innerHTML += `
            <div class="menu-item click" onclick="removeFromCart(${i})">
                <div class="description">
                    <div>${carrello[i].nome}</div>
                    <div>Prezzo: ${carrello[i].prezzo}€</div>
                </div>
            </div>`;
    }
}
function calculate(){
    let tot = 0.0;
    let somma = document.getElementById("calcolatore");
    for(let i = 0; i < carrello.length; i++){
        tot += carrello[i].prezzo;
    }
    somma.innerHTML = `Totale: ${tot.toFixed(2)}€`;
}
function removeFromCart(i) {
    carrello.splice(i, 1);
    updateCart();
}