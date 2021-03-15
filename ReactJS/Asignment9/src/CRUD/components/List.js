import '../css/Screen.css' 

function List(props) {
    return (
        <div className="list">
            {props.message}
        </div>
    )
}
export default List;