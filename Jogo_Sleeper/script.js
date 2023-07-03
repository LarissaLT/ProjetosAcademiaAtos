const hard = [2, 1.7, 1.7, 1.5, 1, 0.5]
const medium = [3, 2, 2, 1.7, 1.5, 1]
const easy = [6, 4, 4, 3.5, 3, 2]
const winLevel = 6;
// let timeDifficulty = easy

// Colors for the circles
const colors = [
    {colorName: 'red', trueColor: 'red', colorNamePT: 'VERMELHO'},
    {colorName: 'chocolate', trueColor: 'chocolate', colorNamePT: 'MARROM'},
    {colorName: 'yellow', trueColor: 'yellow', colorNamePT: 'AMARELO'},
    {colorName: 'orange', trueColor: 'orange', colorNamePT: 'LARANJA'},
    {colorName: 'gray', trueColor: 'gray', colorNamePT: 'CINZA'},
    {colorName: 'black', trueColor: 'black', colorNamePT: 'PRETO'},
    {colorName: 'cyan', trueColor: 'cyan', colorNamePT: 'AZUL'},
    {colorName: 'magenta', trueColor: 'magenta', colorNamePT: 'ROSA'},
    {colorName: 'lime', trueColor: 'lime', colorNamePT: 'VERDE'},
];


// Get the necessary elements
const startBtn = document.getElementById('startBtn');
const colorText = document.getElementById('colorText');
const circleContainer = document.getElementById('circleContainer');
const scoreText = document.getElementById('scoreText');
const timerText = document.getElementById('timerText');
const gameOverText = document.getElementById('gameOverText');
const gameLevelText = document.getElementById('gameLevel');

// Variables to track the game
let score = 0;
let timer;
let timeLeft;
let milliseconds = 0;
let randomColorObject;
let shuffledColors;
let gameLevel;

// Generate a random color object
function getRamdomColorTarget() {
    randomColorObject = colors[Math.floor(Math.random() * colors.length)];
    colorText.textContent = getFalseColorName(randomColorObject)
    colorText.style.color = randomColorObject.trueColor;
}

function getFalseColorName(randomColorObject) {
    let falseColorName = colors[Math.floor(Math.random() * colors.length)].colorNamePT;
    while (randomColorObject.colorNamePT === falseColorName) {
        falseColorName = colors[Math.floor(Math.random() * colors.length)].colorNamePT;
    }
    return falseColorName;
}

function setDifficulty(difficulty) {
    if (difficulty === 'easy') {
        timeDifficulty = easy;
    } else if (difficulty === 'medium') {
        timeDifficulty = medium;
    } else if (difficulty === 'hard') {
        timeDifficulty = hard;
    }
}

// Function to start the game
function startGame(difficulty) {
    if (difficulty) {
        setDifficulty(difficulty);
    }

    endGame()
    console.log('startGame');
    score = 0;
    colorText.textContent = '';
    scoreText.textContent = 'Score: 0';
    timerText.textContent = '';
    gameOverText.style.display = 'none';
    shuffledColors = shuffle(colors);
    createCircles();
    startTimer();
}

function redirectToIndex(difficulty) {
    window.location.href = `index.html?difficulty=${difficulty}`;

    if (difficulty) {
        startGame(difficulty);
    }
}

// Adicione esse código no início do arquivo `index.html` antes de qualquer outro código JavaScript
const urlParams = new URLSearchParams(window.location.search);
const difficulty = urlParams.get('difficulty');

// Chame a função `startGame` com base na dificuldade recuperada
if (difficulty) {
    startGame(difficulty);
}

// Add click event listener to start button
startBtn.addEventListener('click', startGame);

// Function to create the circles
function createCircles() {
    getRamdomColorTarget();
    // Clear circle container
    circleContainer.innerHTML = '';

    // Create the circles in a 4x4 grid
    const gridSize = 3;
    const totalCircles = gridSize * gridSize;

    gameLevel = Math.floor(score / 10) + 1
    gameLevelText.textContent = `Game Level: ${gameLevel}`;
    if (gameLevel > 2) {
        shuffledColors = shuffle(colors);
    }

    for (let i = 0; i < totalCircles; i++) {
        const circle = document.createElement('div');
        circle.classList.add('circle');
        circle.style.backgroundColor = shuffledColors[i].trueColor;
        // circle.textContent = shuffledColors[i].colorName;

        // Add click event listener to each circle
        circle.addEventListener('click', function () {
            console.log('circleClicked');
            if (shuffledColors[i].trueColor === randomColorObject.colorName) {
                // Correct color clicked, increment score and check answer
                console.log('rightColorClicked');
                score++;
                colorText.textContent = '';
                scoreText.textContent = `Score: ${score}`;
                clearInterval(timer);
                timeLeft = timeDifficulty[gameLevel - 1];
                timerText.textContent = `Time: ${timeLeft}`;
                checkAnswer();
            } else {
                // Wrong color clicked, end game
                console.log('wrongColorClicked');
                endGame();
            }
        });

        const col = document.createElement('div');
        col.classList.add('col');
        col.appendChild(circle);

        circleContainer.appendChild(col);
    }
}

// Function to check the answer
function checkAnswer() {
    createCircles();

    if (gameLevel === winLevel) {
        endGame();
        gameOverText.textContent = 'Parabens, voce conseguiu!';
        gameOverText.style.display = 'block';
        return;
    }

    startTimer();
}

// Function to start the timer
function startTimer() {
    // Start the timer
    timeLeft = timeDifficulty[gameLevel - 1];
    timerText.textContent = `Time: ${timeLeft}`;
    timer = setInterval(updateTimer, 1000);
}

// Function to end the game
function endGame() {
    console.log('endGame');
    clearInterval(timer);
    circleContainer.innerHTML = '';
    timeLeft = 0;
    timerText.textContent = `Time: ${timeLeft}`;
    colorText.textContent = '';
    gameOverText.style.display = 'block';

    if (gameLevel === winLevel) {
        return;
    }

}

// Function to update the timer
function updateTimer() {
    console.log('updateTimer');
    timeLeft--;
    timerText.textContent = `Time: ${timeLeft}`;
    if (timeLeft <= 0) {
        endGame();
    }

}

// Function to shuffle an array
function shuffle(array) {
    const newArray = array.slice();
    for (let i = newArray.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [newArray[i], newArray[j]] = [newArray[j], newArray[i]];
    }
    return newArray;
}
