import React, { useState, useEffect } from 'react';
import Button from './components/Button';
import './App.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBackspace, faTimes } from '@fortawesome/free-solid-svg-icons';
import CryptoJS from 'crypto-js';
 
/*import '/home/vandelsoncleitoso/Documentos/Faculdade/git/Grupo-5---PAC-V-2023/ATM-style-ambiguous-keypad/senha_caixa_banco/src/ATM-keypad-api/src/main/java/br/edu/catolicasc/algoritmosAvancados/atmkeypadapi/Usuario.java';

const db = require('/home/vandelsoncleitoso/Documentos/Faculdade/git/Grupo-5---PAC-V-2023/ATM-style-ambiguous-keypad/senha_caixa_banco/src/banco/conn.js');

const CryptoJS = require("crypto-js");
const ITERATIONS = 10000;
const KEY_LENGTH = 128 / 32; // 128 bits = 16 bytes
 
function gerarChave(nome) {
    let salt = CryptoJS.enc.Utf8.parse(nome);
    let key = CryptoJS.PBKDF2(nome, salt, { keySize: KEY_LENGTH, iterations: ITERATIONS });
    return key;
}
 
function criptografar(plaintext, nome) {
    let key = gerarChave(nome);
    let encrypted = CryptoJS.AES.encrypt(plaintext, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });
    return encrypted.toString();
}
 
function decriptografar(ciphertext, nome) {
    let key = gerarChave(nome);
    let decrypted = CryptoJS.AES.decrypt(ciphertext, key, { mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7 });
    return decrypted.toString(CryptoJS.enc.Utf8);
}*/
 
function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
}
 
function App() {
  const [buttonNumbers, setButtonNumbers] = useState([]);
 
  useEffect(() => {
    updateButtonNumbers();
  }, []);
 
  function updateButtonNumbers() {
    const numbers = Array.from({ length: 10 }, (_, i) => i);
    const shuffledNumbers = shuffleArray(numbers);
    const newButtonNumbers = shuffledNumbers.map((num, index) => {
      return `${num} ou ${shuffledNumbers[index + 5]}`;
    });
    setButtonNumbers(newButtonNumbers);
  }
 
  function handleButtonClick(buttonText) {
    const passwordInput = document.getElementById("password-input");
    if (passwordInput.value.length < 6) {
      passwordInput.value += buttonText.split(" ou ")[0];
    }
  }
 
  return (
    <div>
      <div id="buttons-container">
        {buttonNumbers.map((buttonText, index) => (
          <button key={index} onClick={() => handleButtonClick(buttonText)}>
            {buttonText}
          </button>
        ))}
      </div>
      <input id="password-input" type="text" />
    </div>
  );
}
 
export default App;