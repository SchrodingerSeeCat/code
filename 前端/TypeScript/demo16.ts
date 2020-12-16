enum Status{
    MASSAGE, 
    SPA, 
    DA_BAO_JIAN
}

function getServe(status: any) {
    if (status == Status.MASSAGE) {
        return "massage"
    }
    if (status == Status.SPA) {
        return "SPA"
    }
    if (status == Status.DA_BAO_JIAN){
        return "dabaojian"
    }
    return null
}