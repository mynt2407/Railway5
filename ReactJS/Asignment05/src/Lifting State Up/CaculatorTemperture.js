import React from "react";
import TemperatureInput from "./TemperatureInput";

class CaculatorTemperture extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            temperature: ''
            //celsius default
        };
    }
    toCelsius = (fahrenheit) => {
        return (fahrenheit - 32) * 5 / 9;
        //tra ra do C
    }

    toFahrenheit = (celsius) => {
        return (celsius * 9 / 5) + 32;
         //tra ra do F
    }
    handleCelsiusChange = (celsius) =>{
        this.setState({
            temperature: celsius
        });
    }
    handleFahrenheitChange = (fahrenheit) => {
        this.setState({
            temperature: this.toCelsius(fahrenheit)
        });
    }

    render() {
        const celsius = this.state.temperature === "" ? "" : this.state.temperature;
        const fahrenheit = this.state.temperature === "" ? "" : this.toFahrenheit(this.state.temperature);
        return (
            <div>
                <TemperatureInput
                    temperature={celsius}
                    TypeTemperature="Celisus"
                    onTemperatureChange={this.handleCelsiusChange}
                />

                <TemperatureInput
                    temperature={fahrenheit}
                    TypeTemperature="Fahrenheit"
                    onTemperatureChange={this.handleFahrenheitChange}
                />
            </div>
        );
    }
}
export default CaculatorTemperture;