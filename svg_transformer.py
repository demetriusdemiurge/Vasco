import xml.etree.ElementTree as ET
import re

def transform_svg():
    # Путь к исходному и новому файлу
    input_file = 'src/main/resources/static/images/world.svg'
    output_file = 'src/main/resources/static/images/world_transformed.svg'

    # Чтение SVG файла
    tree = ET.parse(input_file)
    root = tree.getroot()

    # Находим все path элементы
    for path in root.findall('.//{http://www.w3.org/2000/svg}path'):
        # Получаем id страны
        country_id = path.get('id')
        if country_id:
            # Создаем новый group элемент
            group = ET.Element('{http://www.w3.org/2000/svg}g')
            group.set('id', f'group_{country_id}')
            
            # Копируем атрибуты path
            path_attrs = path.attrib.copy()
            
            # Создаем новый path внутри группы
            new_path = ET.SubElement(group, '{http://www.w3.org/2000/svg}path')
            for key, value in path_attrs.items():
                new_path.set(key, value)
            
            # Заменяем старый path на новую группу
            parent = root.find('.//{http://www.w3.org/2000/svg}path/...')
            if parent is not None:
                parent.remove(path)
                parent.append(group)

    # Сохраняем результат
    tree.write(output_file, encoding='utf-8', xml_declaration=True)

if __name__ == '__main__':
    transform_svg() 