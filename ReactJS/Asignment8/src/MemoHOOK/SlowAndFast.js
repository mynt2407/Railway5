import React, { useMemo, useState } from 'react';

function SlowAndFast() {
    const [wordIndex, setWordIndex] = useState(0);
    const [count, setCount] = useState(0);

    const words = ['Nguyen', 'Thi', 'My', '123']
    const word = words[wordIndex]

    const computerLetter = word => {
        let i = 0;
        while (i < 1000000000) i++;
        return word.length
    }

    const letterCount = useMemo(
        () => computerLetter(word), [word]
    )

    return (
        <>
            <h2>Slower</h2>
            <p>
                "{word}" has {letterCount} letters
            </p>
            <button
                onClick={() => {
                    const next = wordIndex + 1 === words.length ? 0 : wordIndex + 1;
                    setWordIndex(next);
                }}
            >Next word</button>
            <br />

            <h2>Faster</h2>
            <p>Couter: {count}</p>
            <button
                onClick={() => setCount(count + 1)
                }
            >
                Click me
                </button>
        </>
    )

}
export default SlowAndFast;