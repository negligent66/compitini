async function loadMenu() {
    let negro = document.getElementById("pollo");
    negro.innerHTML = 
        `<div class ="row"> <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="index.html">Home</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Primi.html">Primi</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Dessert.html">Dessert</a></div>
        <div class="col text-center"></div>
        <div class="col text-center voce-menu"><a href="Contatti.html">Contatti</a></div>
        <div class="col text-center"></div>`; 
    let nr = document.getElementById("nero");
    nr.innerHTML = 
        `<div class="container-fluid">
        <br>
        <section class="row">
            <article class="col-6">
                <h2>
                    <div class="titoli titolini">CARNI</div>
                </h2>
            </article>
            <article class="col-6">
                <h2>
                    <div class="titoli titolini">PESCE</div>
                </h2>
            </article>
        </section>
        <section class="row">
            <article class="col-6 scrollable">
                <div class="menu-elementi">
                    <img src="./immagini/hd650x433_wm.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>COSTINE GLASSATE</h2>
                            <p>PREZZO: 22£</p>
                    </div>
                </div>

                <div class="menu-elementi">
                    <img src="./immagini/IMAGE_2024-09-19_111901.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>BLACK ANGUS</h2>
                            <p>PREZZO: 50£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/horizontal pack.webp" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>COTOLETTA DI PORCELLO</h2>
                            <p>PREZZO: 20£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/Spezzatino di manzo con patate e piselli_orizz_b.JPG" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>SPEZZATINO DI MANZO</h2>
                            <p>PREZZO: 23£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/Cevapcici-5.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>CEVAPCICI</h2>
                            <p>PREZZO: 15</p>
                    </div>
                </div>
            </article>
            <article class="col-6 scrollable">
                <div class="menu-elementi">
                    <img src="./immagini/pesce-nero-ricetta.jpg" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>PESCE NEGRO</h2>
                            <p>PREZZO: 24£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/Polpettine-di-tonno-e-ricotta_450x300.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>POLPETTE DI TONNO</h2>
                            <p>PREZZO: 10£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/Calamari-ripieni_450x300.AVIF" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>CALAMARI FARCITI</h2>
                            <p>PREZZO: 15£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/Polpo-alla-Luciana_450x300.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>POLPO ALLA LUCIANA</h2>
                            <p>PREZZO: 16£</p>
                    </div>
                </div>
                <div class="menu-elementi">
                    <img src="./immagini/ttt.avif" alt="non esiste"
                        class="immagini-menu">
                    <div>
                        <h3>TARTARE DI TONNO</h2>
                            <p>PREZZO: 12£</p>
                    </div>
                </div>
            </article>
        </section>
    </div>`;
    let foota = document.getElementById("footerino");
    foota.innerHTML = 
        `<footer>
    <h1 id="text-footer">©COPYRIGHT NEGRONIA</h1>
</footer>`; 
}