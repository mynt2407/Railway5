function Boiling (props) {
    if (props.celsius >= 100) {
        return <p>The water would boild</p>;
    }
    return <p>The water not boild</p>;
}
export default Boiling;