import store2 from "../../Store"

export const counterSelector2 = () => {
    return store2.getState().counter2.value
}