import React from 'react';
class ForceUpdate extends React.Component {
    render(){
        return(
            <div>
                <h1>Random Number {Math.random()}</h1>
                <button onClick = {() => this.forceUpdate()}>Refresh</button>
            </div>
        )
    }
}
export default ForceUpdate;