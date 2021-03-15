import React, { useState } from 'react';

function ReadMore() {

    const [hidden, setHidden] = useState(true);
    const text = " Focused, hard work is the real key to success. Keep your eyes on the goal, and just keep taking the next step towards completing it"
    const maxLength = 35;

    // if (text.length <= maxLength) {
    //     return <span>{text}</span>
    // }

    return (
        <span >
            {hidden ?
                `${text.substr(0, maxLength).trim()}.....`
                : text
            }

            {hidden ?
                (<a onClick={() => setHidden(false)}> <u style ={{color: 'blue'}}>Read more</u></a>)
                :
                (<a onClick={() => setHidden(true)}> <u style ={{color: 'blue'}}>Less more</u></a>)
            }
        </span>
    )
}
export default ReadMore;