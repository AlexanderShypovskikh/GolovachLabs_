# GolovachLabs_
Предлагается сделать блокирующий буфер на один элемент, но передачу сообщения делать не на основе wait()/notify(), а на основе wait()/interrupt(). В следующей ниже "заготовке" замените '// ?' на свои строки. 
    Основная идея заключается в том, что мы явно поддерживаем односвязные списки ожидающих производителей и потребителей. Если нет работы, то поток сам себя добавляет в соответствующий список. Если поток создал работу, то он удаляет поток из соответствующего списка и "будит" его. 