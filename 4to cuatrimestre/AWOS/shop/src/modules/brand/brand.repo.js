const pool = require('../../utils/db.connection');

const QUERIES = [
    'SELECT * FROM brand',
    'SELECT * FROM brand WHERE id = ?',
    'INSERT INTO brand SET ?',
    'UPDATE brand SET ? WHERE id = ?',
    'DELETE FROM brand WHERE id = ?'
];

const findAll = async () => {
    const [rows] = await pool.query(QUERIES[0]); 
    return rows; 
};


//findById
const findById = async (id) => {
    let result = (await pool.query(QUERIES[1], [id]))[0];
    let found = result[0];
    return found;
}

//save
const save = async brand => {
    try{
        await pool.query(QUERIES[2], [brand]);
        return true;
    }catch(e){
        console.log(e);
        return false;
    }
}

//update
const update = async brand => {
    try{
        await pool.query(QUERIES[3], [brand, brand.id]);
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


const brandRepo = {
    findAll,
    findById,
    save,
    update,
    remove
}

module.exports = brandRepo;