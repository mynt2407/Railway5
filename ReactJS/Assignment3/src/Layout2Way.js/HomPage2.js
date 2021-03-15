import React from 'react'
import BodyHorizontal from './BodyHorizontal';
import BodyVertical from './BodyVertical';
import Footer from './Footer';
import HomePage from './HomePage';
import Header from './Header';


class HomePage2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = { direction: "horizotal" }
    }

    changeDirection(d) {
        this.setState({
            direction: d
        })
    }

    render() {
        return (
            <div >
                <button onClick={() => this.changeDirection("horizotal")}>Way one</button>
                <button onClick={() => this.changeDirection("vertical")}>Way two</button>


                <HomePage
                    top={<Header />}
                    main={this.state.direction === "vertical" ? <BodyVertical /> : <BodyHorizontal />}
                    bottom={<Footer />}
                />
            </div>
        )
    }

}
export default HomePage2;