const pool = require('../../utils/db.connection');

const QUERIES = [
    'SELECT p.id, p.name, p.description, p.id_category, c.name AS category_name, p.id_brand, b.name AS brand_name FROM product p INNER JOIN category c ON p.id_category = c.id INNER JOIN brand b ON p.id_brand = b.id',
    'SELECT p.id, p.name, p.description, p.id_category, c.name AS category_name, p.id_brand, b.name AS brand_name FROM product p INNER JOIN category c ON p.id_category = c.id INNER JOIN brand b ON p.id_brand = b.id WHERE p.id = ?',
    'INSERT INTO product SET ?',
    'UPDATE product SET ? WHERE id = ?',
    'DELETE FROM product WHERE id = ?'
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
const save = async product => {
    try{
        await pool.query(QUERIES[2], [product]);
        return true;
    }catch(e){
        console.log(e);
        return false;
    }
}

//update
const update = async product => {
    try{
        await pool.query(QUERIES[3], [product, product.id]);
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


const productRepo = {
    findAll,
    findById,
    save,
    update,
    remove
}

module.exports = productRepo;