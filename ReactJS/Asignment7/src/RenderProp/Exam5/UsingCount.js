import React from 'react';
import Counter from './Count';
class UsingCounter extends React.Component {
    render() {
        return (
            <Counter
                render = {({ increase, decrease, count }) => (
                    <div>
                        <h2>Render Props Counter</h2>
                        <p>{count}</p>
                        <button onClick={() => increase()}>Increase</button>
                        <button onClick={() => decrease()}>Decrease</button>
                    </div>
                )}
            />
        )
    }
}
export default UsingCounter;