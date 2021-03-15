import Todo7 from "./Todo";

function TodoList5(props) {

    console.log(props);
    const todoList = props.todos.map((item, index) =>

        <Todo7
            key={index}
            todo={item.todo}
        />);

    return (
        <ul>
            {todoList}
        </ul>
    )
}
export default TodoList5;