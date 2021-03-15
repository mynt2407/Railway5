import React from 'react';
import Button1 from './Button';
import WarningBanner from './WarningBanner';


class Page extends React.Component {

    //tạo constructor để khởi tạo state
    constructor(props) {
        super(props);
        this.state = { showwing: true }
    }

    handleClick = () => {
        this.setState(
            prevState => ({
                showwing: !prevState.showwing
            })
        )
    }

    render() {
        return (
            <div>
                <WarningBanner warn={this.state.showwing} />
                <Button1 onClick={this.handleClick} >
                    {this.state.showwing ? 'Hide' : 'Show'}
                </Button1>
            </div>
        )
    }
}

export default Page;