const images = [
    { src: "./immagini/cane.jpeg", type: "Dog" },
    { src: "./immagini/gatto.jpeg", type: "Cat" },
    { src: "./immagini/uccello.jpeg", type: "Bird" },
    { src: "./immagini/Hitler_portrait_crop.jpg", type: "Hitler" },
    { src: "./immagini/gattino.jpg", type: "Cat" },
    { src: "./immagini/uccellino.jpg", type: "Bird" }
];

let selectedImages = [];
let targetType = "";

function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

function loadCaptcha() {
    const captchaImagesDiv = document.getElementById('captcha-images');
    const instructionDiv = document.getElementById('captcha-instruction');
    selectedImages = [];

    const shuffledImages = shuffle([...images]);
    targetType = shuffledImages[Math.floor(Math.random() * shuffledImages.length)].type;

    instructionDiv.textContent = `Seleziona tutte le immagini con un ${targetType.toLowerCase()}:`;
    captchaImagesDiv.innerHTML = '';
    shuffledImages.forEach(image => {
        const imgElement = document.createElement('img');
        imgElement.src = image.src;
        imgElement.alt = image.type;
        imgElement.onclick = () => toggleSelection(imgElement, image.type);
        captchaImagesDiv.appendChild(imgElement);
    });
}

function toggleSelection(imgElement, type) {
    if (selectedImages.includes(imgElement)) {
        selectedImages = selectedImages.filter(img => img !== imgElement);
        imgElement.style.borderColor = "transparent";
    } else {
        selectedImages.push(imgElement);
        imgElement.style.borderColor = "#007bff";
    }
}

function verifyCaptcha() {
    const resultDiv = document.getElementById('captcha-result');
    const allCorrect = selectedImages.every(img => img.alt === targetType);
    const allCorrectCount = document.querySelectorAll(`img[alt='${targetType}']`).length;

    if (allCorrect && selectedImages.length === allCorrectCount) {
        resultDiv.innerHTML = '<p style="color: green;">Verifica completata con successo!</p>';
    } else {
        resultDiv.innerHTML = '<p style="color: red;">Verifica fallita. Riprova.</p>';
    }
}