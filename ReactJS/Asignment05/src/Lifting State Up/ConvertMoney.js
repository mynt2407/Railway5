import React from "react";
import MoneyInput from "./MoneyInput";

class ConvertMoney extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            money: ''
            //vnd default
        };
    }
    toVND = (usd) => {
        return usd * 23.600;
        //tra ra do C
    }

    toUSD = (vnd) => {
        return (vnd / 23.600);
        //tra ra USD
    }
    handleVNDChange = (vnd) => {
        this.setState({
            money: vnd
        });
    }
    handleUSDChange = (usd) => {
        this.setState({
            money: this.toVND(usd)
        });
    }

    render() {
        const vnd = this.state.money === "" ? "" : this.state.money;
        const usd = this.state.money === "" ? "" : this.toUSD(this.state.money);
 
        return (
            <div>
                <MoneyInput
                    money={vnd}
                    TypeMoney="VND"
                    onMoneyChange={this.handleVNDChange}
                />
                <br />
                <MoneyInput
                    money={usd}
                    TypeMoney="USD"
                    onMoneyChange={this.handleUSDChange}
                />
            </div>
        );
    }
}
export default ConvertMoney;