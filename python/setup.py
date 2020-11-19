import io
from setuptools import find_package, setup

def long_description() :
    with io.open('README.md', 'r', encoding='utf-8') as f:
        readme = f.read()
    return readme

setup(
    name='algorithm',
    version='0.1',
    description='practice python with solving algorithms',
    long_description=long_description(),
    url='',
    author='',
    author_email='',
    license='',
    classifiers=[
        'Programming Language :: Python :: 3.6',
        ],
    zip_safe=False
)

