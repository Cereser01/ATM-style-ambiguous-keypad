import React, { useState } from 'react';
import Button from './components/Button';
import './App.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBackspace, faTimes } from '@fortawesome/free-solid-svg-icons';

function App() {
  const [options, setOptions] = useState('');

  const handleButtonClick = (label, iconName) => {
    if (iconName === 'faBackspace') {
      setOptions(options.slice(0, -1));
    } else {
      setOptions(options + label[label.length - 1]);
    }
  };

  const maskedOptions = options.replace(/./g, '*');

  return (
    <div className="app-container">
      <div className="button-row">
        <Button label="3 ou 9" onClick={() => handleButtonClick("3 ou 9")} />
        <Button label="0 ou 5" onClick={() => handleButtonClick("0 ou 5")} />
        <Button label="2 ou 8" onClick={() => handleButtonClick("2 ou 8")} />
      </div>
      <div className="button-row">
        <Button label="1 ou 4" onClick={() => handleButtonClick("1 ou 4")} />
        <Button label="6 ou 7" onClick={() => handleButtonClick("6 ou 7")} />
        <Button
          onClick={() => handleButtonClick('Apagar', 'faBackspace')}
          label="Apagar"
          icon={<FontAwesomeIcon icon={faTimes} />}
        />
      </div>
      <div className="options-container">
        <p className="options-description">Digite sua senha:</p>
        <p className="options">{maskedOptions}</p>
      </div>
      <div className="button-row">
        <Button label="Acessar" onClick={() => handleButtonClick("Acessar")} fullWidth />
      </div>
    </div>
  );
}

export default App;