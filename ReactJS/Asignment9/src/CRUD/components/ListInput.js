import { connect } from "react-redux";
import List from "./List";

function ListInput(props) {

    const messageList = props.inputs.map((item, index) =>

        <List
            key={index}
            message={item}
        />)

    return (
        <ul>
            {messageList}
        </ul>
    );
}
const mapGlobalStateToProps = state => {
    return {
        inputs: state.input.inputs
    }
}
//input : ten cua reducer trong file index
//inputs : la state ban dau cua reducer
export default connect(mapGlobalStateToProps)(ListInput);