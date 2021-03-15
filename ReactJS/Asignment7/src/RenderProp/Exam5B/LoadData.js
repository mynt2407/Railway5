import axios from 'axios';
import React from 'react';

class LoadData extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [],
            isLoading: true
        }
    }

    getListMember() {

        axios.get(this.props.link)
            .then(response => {
                this.setState(
                    {
                        list: response.data,
                        isLoading: false
                    });
            })
            .catch(error => console.log("Loi roi!"))
    }

    componentDidMount() {
        this.setState({ isLoading: true }, this.getListMember)
    }

    render() {
        return (
            <div>
                {this.props.render(this.state)}
            </div>
        )
    }
}
export default LoadData;