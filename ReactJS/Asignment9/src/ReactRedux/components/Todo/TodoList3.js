import Todo3 from "./Todo3";
import { connect } from "react-redux";

function TodoList3(props) {

    //const [todos, updateTodos] = useState(selectData2())

    const todoList = props.todos.map((item, index) =>

        <Todo3
            key={index}
            todo={item}
        />)

    // const updateList = () => store2.subscribe(() => updateTodos(selectData2()));
    // updateList();

    return (
        <ul>
            {todoList}
        </ul>
    );
}
const mapGlobalStateToProps = state => {
    return {
        todos: state.todo3.todos
    }
}
//todo3 : ten cua reducer trong file index
//todos : la state ban dau cua reducer
export default connect(mapGlobalStateToProps)(TodoList3);