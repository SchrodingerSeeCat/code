/**
 * 创建count组件的action
 */
import {INCREMENT, DECREMENT} from '../constant'

export const increment = (data) => {
    return {type: INCREMENT, data: data}
}

// 同步action，就是指action的值为一般对象
export const decrement = (data) => {
    return {type: DECREMENT, data: data}
}

// 异步action，就是指action的值为函数,异步action中一般都会调用同步action
export const incrementAsync = (data, time) => {
    return (dispatch) => {
        setTimeout(() => {
            // 通知redux修改状态
            dispatch(increment(data))
        }, time)
    }
}