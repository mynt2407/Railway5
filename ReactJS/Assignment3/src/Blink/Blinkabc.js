import React, { useEffect } from 'react';
import './blink.css'

const Blink = () => {
    const [isShowingText, setIsShowingText] = useState(true);

    useEffect(() => {
        const toggle = setInterval(() => {
            setIsShowingText(!isShowingText);
        }, 1000);
        return () => clearInterval(toggle);
    }

    );

    useEffect();
    return (
        <div className="blink">
            {this.state.isShowingText ? (<span>20s</span>) : null}
        </div>
    );
}


export default Blink;