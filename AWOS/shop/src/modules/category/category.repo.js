const pool = require('../../utils/db.connection');

const QUERIES = [
    'SELECT * FROM category',
    'SELECT * FROM category WHERE id = ?',
    'INSERT INTO category SET ?',
    'UPDATE category SET ? WHERE id = ?',
    'DELETE FROM category WHERE id = ?'
];

const findAll = async () => {
    return await pool.query(QUERIES[0])[0];
}

//findById
const findById = async (id) => {
    let result = (await pool.query(QUERIES[1], [id]))[0];
    let found = result[0];
    return found;
}

//save
const save = async category => {
    try{
        await pool.query(QUERIES[2], [category]);
        return true;
    }catch(e){
        console.log(e);
        return false;
    }
}

//update
const update = async category => {
    try{
        await pool.query(QUERIES[3], [category, category.id]);
        return true;
    }catch(e){
        console.log(e);
        return false;
    }
}

//delete
const remove = async id => {
    try{
        await pool.query(QUERIES[4], [id]);
        return true;
    }catch(e){
        console.log(e);
        return false;
    }
}


const categoryRepo = {
    findAll,
    findById,
    save,
    update,
    remove
}

module.exports = categoryRepo;