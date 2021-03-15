import {INCREASE} from '../actionType';
import {DECREASE} from '../actionType';

 export const increaseCounter = () => {
    return {
        type: INCREASE
        //payLoad: khong can, do khong co data
    }
}

export const decreaseCounter = () => {
    return {
        type: DECREASE
        //payLoad: khong can, do khong co data
    }
}
