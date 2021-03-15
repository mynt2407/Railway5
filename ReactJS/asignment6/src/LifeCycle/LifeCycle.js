import React from 'react';

class LifeCycleDemo extends React.Component {

    //tạo constructor để khởi tạo state
    constructor(props) {
        super(props);
        this.state = { message: "Hello babe" };
        console.log("contructor");
    }
    //render ra 
    render() {
        return (
            <div>
                <h3>{this.state.message}</h3>
                <button onClick={this.changeState}>Change State</button>
            </div>
        );
    }

    //Component đã được đính kèm vào cây DOM và được hiển thị lên màn hình. 
    //Tại đây có thể call API, subcription event 
    componentDidMount() {
        console.log("componentDidMount");
    }


    changeState = () => {
        this.setState({
            message: "Hello My Nguyen"
        })
        console.log("Set state");
    }

    //Set xem có nên update component không. nếu return true thì component được update và render lại 
    shouldComponentUpdate = (newProps, newState) => {
        console.log("shouldComponentUpdate " + true);
        return true;
    }

    //Khi component đã update thành công. Tại đây có thể lấy props/state hiện tại và props/state cũ để so sánh
    componentDidUpdate(prevProps, prevState) {
        console.log("componentDidUpdate");
    }

    //Cancel request đi trước khi component bị hủy
    componentWillUnmount() {
        console.log("componentWillUnmount");
    }
    
    //Nếu có lỗi sẽ vào đây
    componentDidCatch(error, info) {
        console.log("componentDidCatch");
    }
}
export default LifeCycleDemo;