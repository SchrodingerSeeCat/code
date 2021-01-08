/**
 * 该文件专门为Count组件生成action对象
 */
import {INCREMENT, DECREMENT} from './constant'

export const createIncrementAction = (data) => {
    return {type: INCREMENT, data: data}
}

export const createDecrementAction = (data) => {
    return {type: DECREMENT, data: data}
}