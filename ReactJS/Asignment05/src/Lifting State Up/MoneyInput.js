import React from "react";

class MoneyInput extends React.Component {
    render() {
        return (
            <fom>
                <label>Enter Money By {this.props.TypeMoney}: </label>
                <input
                    value={this.props.money}
                    onChange={(e) => this.props.onMoneyChange(e.target.value)}
                />
            </fom>
        )
    }

}
export default MoneyInput;