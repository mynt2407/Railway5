import React, { useReducer } from 'react';
import DeletePerson from './DeleteListPerson';

function DeleteAdd(props) {

    const [listPerson, dispatch] = useReducer((prevState, action) => {
        switch (action.type) {
            case 'DELETE':
                return prevState;

            case 'ADD':
                return;

            default:
                throw new Error();
        }
    }, props.persons);

    return (
        <>
            <button

            >Click to add</button>

            <DeletePerson onClick={props.click}
                onClick={() => dispatch({ type: 'DELETE' })}
            />

        </>
    )
}
export default DeleteAdd;