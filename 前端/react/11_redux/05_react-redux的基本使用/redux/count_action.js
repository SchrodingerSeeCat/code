/**
 * 该文件专门为Count组件生成action对象
 */
import {INCREMENT, DECREMENT} from './constant'

export const createIncrementAction = (data) => {
    return {type: INCREMENT, data: data}
}

// 同步action，就是指action的值为一般对象
export const createDecrementAction = (data) => {
    return {type: DECREMENT, data: data}
}

// 异步action，就是指action的值为函数,异步action中一般都会调用同步action
export const createIncrementAsyncAction = (data, time) => {
    return (dispatch) => {
        setTimeout(() => {
            // 通知redux修改状态
            dispatch(createIncrementAction(data))
        }, time)
    }
}